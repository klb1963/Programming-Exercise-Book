package album.dao;

import album.model.Photo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AlbumDateSortedImpl implements Album {
    private Photo[] photos;
    private int size;
    private Comparator<Photo> comparator = (p1, p2) -> {
        int res = p1.getDate().compareTo(p2.getDate());
        return res != 0 ? res : Integer.compare(p1.getAlbumId(), p2.getAlbumId());
    };

    public AlbumDateSortedImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || size == photos.length
                || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
            return false;
        }
        int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(photos, index, photos, index + 1, size - index);
        photos[index] = photo;
        size++;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                photos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        Photo photo = getPhotoFromAlbum(photoId, albumId);
        if (photo == null) {
            return false;
        }
        photo.setUrl(url);
        return true;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return findPhotosByPredicate(p -> p.getAlbumId() == albumId);
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        Photo pattern = new Photo(Integer.MIN_VALUE, 0, null, null, dateFrom.atStartOfDay());
        int from = Arrays.binarySearch(photos, 0, size, pattern, comparator);
        from = from >= 0 ? from : -from - 1;
        pattern = new Photo(Integer.MAX_VALUE, 0, null, null, dateTo.atTime(LocalTime.MAX));
        int to = Arrays.binarySearch(photos, 0, size, pattern, comparator);
        to = to >= 0 ? to : -to - 1;
        return Arrays.copyOfRange(photos, from, to);
    }

    @Override
    public int size() {
        return size;
    }

    private Photo[] findPhotosByPredicate(Predicate<Photo> predicate) {
        Photo[] res = new Photo[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                res[j++] = photos[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
