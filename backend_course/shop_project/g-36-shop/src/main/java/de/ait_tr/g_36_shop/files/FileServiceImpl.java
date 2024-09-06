package de.ait_tr.g_36_shop.files;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import de.ait_tr.g_36_shop.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final AmazonS3 client;
    private final ProductService productService;

    public FileServiceImpl(AmazonS3 client, ProductService productService) {
        this.client = client;
        this.productService = productService;
    }

    @Override
    public String upload(MultipartFile file, String productTitle) {

        try {
            String uniqueFileName = generateFileName(file);  // метод ниже

            // Сохранение в локальную папку приложения (если нужно)
//            Files.copy(file.getInputStream(),
//                    Path.of("C:\\IdeaProjects\\shop\\files\\" + fullFileName));

            ObjectMetadata metaData = new ObjectMetadata(); // объект для метаданных о файле
            metaData.setContentType(file.getContentType()); // получаем эти метаданные
            PutObjectRequest request = new PutObjectRequest( //
                    //так передаем файл не изменяя его имя
                    // "cohort36shopimages", file.getOriginalFilename(), file.getInputStream(), metaData
                    // а так передаем файл с измененным именем, которое делает метод generateFileName
                    "cohort36shopimages", uniqueFileName, file.getInputStream(), metaData
            ).withCannedAcl(CannedAccessControlList.PublicRead); // формируем запрос и его атрибут для чтения пользователями

            client.putObject(request); // отправляем в облако

            String url = client.getUrl("cohort36shopimages", uniqueFileName).toString(); // получаем ссылку на файл из хранилища

            // return url; // имя файла для отладки

            productService.attachImage(url, productTitle);
            return uniqueFileName;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateFileName(MultipartFile file) {
        String sourceFileName = file.getOriginalFilename();
        int dotIndex = sourceFileName.lastIndexOf("."); // ищем индекс точки в строке - имени файла, ищем с правого конца строки
        String fileName = sourceFileName.substring(0, dotIndex); // берем подстроку до точки
        String extension = sourceFileName.substring(dotIndex); // берем подстроку после точки

        return String.format("%s-%s%s", fileName, UUID.randomUUID(), extension);
    }

}
