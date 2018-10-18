public class CommonPath {

    public static void main(String[] args){
        String[] paths = new String[3];

        paths[0] = "/home/User/Desktop/gfg/test";
        paths[1] = "/home/User/Desktop/gfg/file";
        paths[2] = "/home/User/Desktop/geeks/folders";

        String res = FindCommonPath(paths);
        System.out.println(res);


    }

    public static String FindCommonPath(String[] paths){
        String commonPath = "";
        String[][] folders = new String[paths.length][];

        for(int i=0; i<paths.length; i++){
            folders[i] = paths[i].split("/");
        }

        for(int j = 0; j< folders[0].length; j++){
            String s = folders[0][j];
            for(int i=1; i<paths.length; i++){
                if(!s.equals(folders[i][j]))
                    return commonPath;
            }
            commonPath += s + "/";
        }
        return commonPath;
    }
}
