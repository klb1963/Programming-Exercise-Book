package album_date.src.ait.album.test;

import album_date.src.ait.album.dao.Album;
import album_date.src.ait.album.dao.AlbumDateSortedImpl;
import album_date.src.ait.album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    Album album;
    Photo[] photos;
    LocalDateTime now = LocalDateTime.now();
    Comparator<Photo> comparator = (p1, p2) -> {
      int res = Integer.compare(p1.getAlbumId(), p2.getAlbumId());
      return res != 0 ? res : Integer.compare(p1.getPhotoId(), p2.getPhotoId());
    };

    @BeforeEach
    void setUp() {
        album = new AlbumDateSortedImpl(7);
        photos = new Photo[6];
        photos[0] = new Photo(1, 1, "title1", "url1", now.minusDays(7));
        photos[1] = new Photo(1, 2, "title2", "url2", now.minusDays(7));
        photos[2] = new Photo(1, 3, "title3", "url3", now.minusDays(5));
        photos[3] = new Photo(2, 1, "title1", "url1", now.minusDays(7));
        photos[4] = new Photo(2, 4, "title4", "url4", now.minusDays(2));
        photos[5] = new Photo(1, 4, "title4", "url1", now.minusDays(2));
        for (int i = 0; i < photos.length; i++) {
            album.addPhoto(photos[i]);
        }
    }

    @Test
    void addPhoto() {
        assertFalse(album.addPhoto(null));
        assertFalse(album.addPhoto(photos[1]));
        Photo photo = new Photo(1, 5, "title5", "url5", now.minusDays(3));
        assertTrue(album.addPhoto(photo));
        assertEquals(7, album.size());
        photo = new Photo(1, 6, "title6", "url6", now.minusDays(3));
        assertFalse(album.addPhoto(photo));
    }

    @Test
    void removePhoto() {
        assertFalse(album.removePhoto(5, 1));
        assertTrue(album.removePhoto(1, 1));
        assertEquals(5, album.size());
        assertNull(album.getPhotoFromAlbum(1, 1));
    }

    @Test
    void updatePhoto() {
        assertTrue(album.updatePhoto(1, 1, "newUrl"));
        assertEquals("newUrl", album.getPhotoFromAlbum(1, 1).getUrl());
    }

    @Test
    void getPhotoFromAlbum() {
        assertEquals(photos[0], album.getPhotoFromAlbum(1, 1));
        assertNull(album.getPhotoFromAlbum(1, 5));
    }

    @Test
    void getAllPhotoFromAlbum() {
        Photo[] actual = album.getAllPhotoFromAlbum(2); // {photos[4], photos[3]} OR {photos[3], photos[4]}
        Arrays.sort(actual, comparator);
        Photo[] expected = {photos[3], photos[4]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getPhotoBetweenDate() {
        LocalDate localDate = LocalDate.now();
        Photo[] actual = album.getPhotoBetweenDate(localDate.minusDays(5), localDate.minusDays(2));
        Arrays.sort(actual, comparator);
        Photo[] expected = {photos[2], photos[5], photos[4]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(6, album.size());
    }
}