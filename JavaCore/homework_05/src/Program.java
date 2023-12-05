import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    private static Random random = new Random();

    private static int CHAR_BOUND_L = 65;
    private static int CHAR_BOUND_H = 90;
    private static final String TO_SEARCH = "GeekBrains";


    /**
     1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     4.* Написать метод, проверяющий, есть ли указанное слово в папке
     */
    public static void main(String[] args) throws IOException {
        System.out.println(generateSymbols(67));
        writeFileContents("sample01.txt", random.nextInt(50, 101));
        writeFileContents("sample02.txt", random.nextInt(50, 101));

        concatenate("sample01.txt", "sample02.txt", "sample_out.txt");

        String fileNameToSearch = "sample03.txt";
        writeFileContentsV2(fileNameToSearch, 2);

        System.out.printf("Файл '%s' %s '%s'\n", fileNameToSearch,
                searchInFile(fileNameToSearch, TO_SEARCH) ? "contains the desired value" :
                        "not contains the desired value", TO_SEARCH);

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++){
            fileNames[i] = "file_" + i + ".txt";
            writeFileContentsV2(fileNames[i], 2);
            System.out.printf("File %s has been created.\n", fileNames[i]);
        }

        List<String> res = searchMatch(new File("."), TO_SEARCH);
        for (String fileName : res) {
            System.out.printf("File '%s' contains the desired value '%s'\n",
                    fileName, TO_SEARCH);
        }


    }

    private static List<String> searchMatch(File file, String search) throws IOException{
        List<String> list = new ArrayList<>();
        File[] files = file.listFiles();
        if (files == null)
            return list;
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){
                if (searchInFile(files[i].getCanonicalPath(), search))
                    list.add(files[i].getCanonicalPath());
            }
        }
        return list;
    }

    /**
     * Method for generating a certain sequence of characters
     * @param amount
     * @return
     */
    private static String generateSymbols(int amount){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            stringBuilder.append((char)random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        }
        return stringBuilder.toString();
    }

    private static void writeFileContents(String fileName, int length) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(generateSymbols(length).getBytes());
        }
    }

    private static void writeFileContentsV2(String fileName, int maxWords) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(generateSymbols(random.nextInt(30, 51)).getBytes());
            for(int i = 0; i < maxWords; i++){
                if (random.nextInt(3) == 0) // 33%
                {
                    fileOutputStream.write(TO_SEARCH.getBytes());
                    fileOutputStream.write(generateSymbols(random.nextInt(30, 51)).getBytes());
                }
            }
        }
    }

    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException{
        // На запись
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileOut)){

            int c;

            // На чтение 1
            try(FileInputStream fileInputStream = new FileInputStream(fileIn1)){
                while ((c = fileInputStream.read()) != -1){
                    fileOutputStream.write(c);
                }
            }

            // На чтение 2
            try(FileInputStream fileInputStream = new FileInputStream(fileIn2)){
                while ((c = fileInputStream.read()) != -1){
                    fileOutputStream.write(c);
                }
            }
        }
    }

    private static boolean searchInFile(String fileName, String search) throws IOException{
        try(FileInputStream fileInputStream = new FileInputStream(fileName)){
            byte[] searchData = search.getBytes();
            int c;
            int i = 0;
            while ((c = fileInputStream.read()) != -1){
                if (c == searchData[i]){
                    i++;
                }
                else {
                    i = 0;
                    if (c == searchData[i])
                        i++;
                }
                if (i == searchData.length){
                    return true;
                }
            }
            return false;
        }
    }



}
