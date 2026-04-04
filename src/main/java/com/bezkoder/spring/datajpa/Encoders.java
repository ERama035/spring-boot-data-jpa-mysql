package com.bezkoder.spring.datajpa;

import org.apache.tomcat.util.codec.binary.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Encoders {
    public static void main11(String[] args) {
        String filePath = "C:\\Users\\sandh\\Downloads\\DTABA-1234.txt"; // Replace with the actual file path

        try {
            // Read the entire file content as a string
            String content = Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public static void main1(String[] args) {
            String filePath = "C:\\Users\\sandh\\Downloads\\DTABA-1234.txt"; // Replace with the actual file path

            StringBuilder contentBuilder = new StringBuilder();

            try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.US_ASCII)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String content = contentBuilder.toString();
            System.out.println(content);
        }




        public static void mainn(String[] args) throws IOException {
            String filePath = "C:\\Users\\sandh\\Downloads\\DTABA-1234.txt"; // Replace with the actual file path

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String malformedString = new String(bytes, StandardCharsets.ISO_8859_1);

            // Decode the bytes to the correct string using UTF-8 encoding
            String correctedString = new String(malformedString.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);


            String convertedString = new String(bytes, "Windows-1252");
            System.out.println(convertedString);

            String rawString = "sï¿½ï¿½Wï¿½ï¿½ï¿½ï¿½ï¿½";
            byte[] bytess = StringUtils.getBytesUtf8(rawString);

            String utf8EncodedString = StringUtils.newStringUtf8(bytess);


           System.out.println("Corrected string: " + utf8EncodedString);
        }


    public static void mains(String []args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String sources = "C:\\Users\\sandh\\Downloads\\DTABA-1234.txt"; // Replace with the actual file path
        String targets = "C:\\Users\\sandh\\Downloads\\DTABA-12345.txt"; // Replace with the actual file path
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(sources),StandardCharsets.UTF_8));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targets), StandardCharsets.US_ASCII));
            char[] buffer = new char[16384];
            int read;
            while ((read = br.read(buffer)) != -1)
                bw.write(buffer, 0, read);
        } finally {
            try {
                if (br != null)
                    br.close();
            } finally {
                if (bw != null)
                    bw.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        String sources = "C:\\Users\\sandh\\Downloads\\DTABA-1234.txt"; // Replace with the actual file path
        String targets = "C:\\Users\\sandh\\Downloads\\DTABA-12345.txt"; // Replace with the actual file path



        Files.write(Paths.get(targets),
                Charset.forName("UTF-8")
                .encode(Charset.forName("windows-1252")
                .decode(ByteBuffer.wrap(Files.readAllBytes(Paths.get(sources))))).array());
    }
    }




