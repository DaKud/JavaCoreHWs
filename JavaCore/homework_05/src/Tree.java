import java.io.File;

public class Tree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    private static void print(File file, String indent, boolean isLast){
        System.out.print(indent); // рисуем отступ
        if (isLast){
            System.out.print("└─");
            indent += '\t';
        }
        else {
            System.out.print("├─");
            indent += "│\t";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int totalObjects = files.length;
        int objectCounter = 0;
        for(int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                print(files[i], indent, totalObjects  == ++objectCounter);
            } else {
                print(files[i], indent, totalObjects  == ++objectCounter);
            }
        }
    }



}
