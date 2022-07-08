package com.lvl80;

import com.lvl80.dao.BooksDao;
import com.lvl80.dao.ClientsDao;
import com.lvl80.model.Books;
import com.lvl80.model.Clients;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ClientsDao clientsDao = new ClientsDao();
        BooksDao booksDao = new BooksDao();

        List<Clients> clientsList = clientsDao.findAll();
        clientsList.forEach((System.out::println));

        for (Books books : booksDao.findAll())
            System.out.println(books);


    }
}
