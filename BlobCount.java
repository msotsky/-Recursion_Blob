import java.io.*;
import java.util.*;
public class BlobCount {
    public static void main(String[] args){
        if(args.length > 0){
            return;
        }
        try{
            File file = new File(args[0]);
            Scanner sc = new Scanner(file);

            int r = sc.nextInt();
            int c = sc.nextInt();

            char[][] blob = new char[r][c];
            sc.nextLine();
            for(int i = 0; i < r; i++){
                String line = sc.nextLine();
                for(int j = 0; j < c; j++){
                    blob[i][j] = line.charAt(j);
                }
            }
            int count = countBlob(blob);

        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }
    public static int countBlob(char[][] blobIn){
        int count = 0;
        for(int r = 0; r < blobIn.length; r++){
            for(int c = 0; c < blobIn[r].length; c++){
                if(blobIn[r][c] == '0'){
                    count++;
                    colourBlob(blobIn,r,c);
                }
            }
        }
        return count;
    }

    public static void colourBlob(char[][] blob, int r, int c){
        blob[r][c] = '3';

        if(r+1 < blob.length && blob[r + 1][c] == '0'){
            colourBlob(blob,r+1,c);
        }
        if(r -1 >= 0 && blob[r - 1][c] == '0'){
            colourBlob(blob,r-1,c);
        }
        if(c + 1 < blob.length && blob[r][c + 1] == '0'){
            colourBlob(blob,r,c+1);
        }
        if(c - 1 >= 0 && blob[r][c - 1] == '0'){
            colourBlob(blob,r,c-1);
        }
    }
}
