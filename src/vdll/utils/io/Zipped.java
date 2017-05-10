package vdll.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Android Zip压缩解压缩
 *
 * @author Ren.xia
 * @version 1.0
 * @updated 26-七月-2010 13:04:27
 */
public class Zipped {


    /**
     * 取得压缩包中的 文件列表(文件夹,文件自选)
     *
     * @param zipFileString  压缩包名字
     * @param bContainFolder 是否包括 文件夹
     * @param bContainFile   是否包括 文件
     * @return
     * @throws Exception
     */
    public static java.util.List<File> GetFileList(String zipFileString, boolean bContainFolder, boolean bContainFile) throws Exception {


        java.util.List<File> fileList = new java.util.ArrayList<File>();
        java.util.zip.ZipInputStream inZip = new java.util.zip.ZipInputStream(new FileInputStream(zipFileString));
        ZipEntry zipEntry;
        String szName = "";

        while ((zipEntry = inZip.getNextEntry()) != null) {
            szName = zipEntry.getName();

            if (zipEntry.isDirectory()) {

                // get the folder name of the widget
                szName = szName.substring(0, szName.length() - 1);
                File folder = new File(szName);
                if (bContainFolder) {
                    fileList.add(folder);
                }

            } else {
                File file = new File(szName);
                if (bContainFile) {
                    fileList.add(file);
                }
            }
        }//end of while

        inZip.close();

        return fileList;
    }

    /**
     * 返回压缩包中的文件InputStream
     *
     * @param zipFileString 压缩文件的名字
     * @param fileString    解压文件的名字
     * @return InputStream
     * @throws Exception
     */
    public static java.io.InputStream UpZip(String zipFileString, String fileString) throws Exception {
        @SuppressWarnings("resource")
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(zipFileString);
        ZipEntry zipEntry = zipFile.getEntry(fileString);

        return zipFile.getInputStream(zipEntry);

    }


    /**
     * 解压一个压缩文档 到指定位置
     *
     * @param zipFileString 压缩包的名字
     * @param outPathString 指定的路径
     * @throws Exception
     */
    public static void UnZipFolder(String zipFileString, String outPathString) throws Exception {
        java.util.zip.ZipInputStream inZip = new java.util.zip.ZipInputStream(new FileInputStream(zipFileString));
        ZipEntry zipEntry;
        String szName = "";

        while ((zipEntry = inZip.getNextEntry()) != null) {
            szName = zipEntry.getName();

            if (zipEntry.isDirectory()) {

                // get the folder name of the widget
                szName = szName.substring(0, szName.length() - 1);
                File folder = new File(outPathString + File.separator + szName);
                folder.mkdirs();

            } else {

                File file = new File(outPathString + File.separator + szName);
                file.createNewFile();
                // get the output stream of the file
                FileOutputStream out = new FileOutputStream(file);
                int len;
                byte[] buffer = new byte[1024];
                // read (len) bytes into buffer
                while ((len = inZip.read(buffer)) != -1) {
                    // write (len) byte from buffer at the position 0
                    out.write(buffer, 0, len);
                    out.flush();
                }
                out.close();
            }
        }//end of while

        inZip.close();

    }//end of func


    /**
     * 压缩文件,文件夹
     *
     * @param srcFileString 要压缩的文件/文件夹名字
     * @param zipFileString 指定压缩的目的和名字
     * @throws Exception
     */
    public static void ZipFolder(String srcFileString, String zipFileString) throws Exception {

        //创建Zip包
        ZipOutputStream outZip = new ZipOutputStream(new FileOutputStream(zipFileString));

        //打开要输出的文件
        File file = new File(srcFileString);

        //压缩
        ZipFiles(file.getParent() + File.separator, file.getName(), outZip);

        //完成,关闭
        outZip.finish();
        outZip.close();

    }//end of func

    /**
     * 压缩文件
     *
     * @param folderString
     * @param fileString
     * @param zipOutputSteam
     * @throws Exception
     */
    private static void ZipFiles(String folderString, String fileString, ZipOutputStream zipOutputSteam) throws Exception {

        if (zipOutputSteam == null)
            return;

        File file = new File(folderString + fileString);

        //判断是不是文件
        if (file.isFile()) {

            ZipEntry zipEntry = new ZipEntry(fileString);
            FileInputStream inputStream = new FileInputStream(file);
            zipOutputSteam.putNextEntry(zipEntry);

            int len;
            byte[] buffer = new byte[4096];

            while ((len = inputStream.read(buffer)) != -1) {
                zipOutputSteam.write(buffer, 0, len);
            }

            zipOutputSteam.closeEntry();
        } else {

            //文件夹的方式,获取文件夹下的子文件
            String fileList[] = file.list();

            //如果没有子文件, 则添加进去即可
            if (fileList.length <= 0) {
                ZipEntry zipEntry = new ZipEntry(fileString + File.separator);
                zipOutputSteam.putNextEntry(zipEntry);
                zipOutputSteam.closeEntry();
            }

            //如果有子文件, 遍历子文件
            for (int i = 0; i < fileList.length; i++) {
                ZipFiles(folderString, fileString + File.separator + fileList[i], zipOutputSteam);
            }//end of for

        }//end of if

    }//end of func

    public void finalize() throws Throwable {

    }


    //region  limingda zip
    /**
     * java压缩成zip
     * 创建人：limingda
     * 创建时间：2016年4月16日
     * @version
     */
    /**
     * @param inputFileName 你要压缩的文件夹(整个完整路径)
     * @param zipFileName   压缩后的文件(整个完整路径)
     */
    public static void zip(String inputFileName, String zipFileName) throws Exception {
        zip(zipFileName, new File(inputFileName));
    }

    private static void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                zipFileName));
        zip(out, inputFile, "");
        out.flush();
        out.close();
    }

    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
                zip(out, fl[i], base + fl[i].getName());
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            //System.out.println(base);
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
        }
    }

    public static void main(String[] temp) {
        try {
            zip("E:\\ftl", "E:\\test.zip");//你要压缩的文件夹      和  压缩后的文件
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //=====================文件压缩=========================
/*//把文件压缩成zip
File zipFile = new File("E:/demo.zip");
//定义输入文件流
InputStream input = new FileInputStream(file);
//定义压缩输出流
ZipOutputStream zipOut = null;
//实例化压缩输出流,并制定压缩文件的输出路径  就是E盘下,名字叫 demo.zip
zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
zipOut.putNextEntry(new ZipEntry(file.getName()));
//设置注释
zipOut.setComment("www.demo.com");
int temp = 0;
while((temp = input.read()) != -1) {
	zipOut.write(temp);
}
input.close();
zipOut.close();*/
//=============================================
    //endregion
}