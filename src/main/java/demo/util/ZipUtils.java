package demo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	private static void zip1(ZipOutputStream out, File f, String base,
			BufferedOutputStream bo) throws Exception { // 方法重载
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			if (fl.length == 0) {
				out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base
			}
			for (int i = 0; i < fl.length; i++) {
				zip1(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹
			}
		} else {
			out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
			System.out.println(base);
			FileInputStream inputStream = new FileInputStream(f);
			BufferedInputStream bi = new BufferedInputStream(inputStream);
			int b;
			while ((b = bi.read()) != -1) {
				bo.write(b); // 将字节流写入当前zip目录
			}
			bi.close();
			inputStream.close(); // 输入流关闭
		}
	}

	public static void zip(File source, File zipFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		BufferedOutputStream bo = new BufferedOutputStream(out);
		zip1(out, source, source.getName(), bo);
		bo.close();
		out.close(); // 输出流关闭
	}

	public static void unzip(File zipFile, File dir) throws Exception {
		ZipFile zipFile1 = new ZipFile(zipFile);// 实例化ZipFile，每一个zip压缩文件都可以表示为一个ZipFile
		// 实例化一个Zip压缩文件的ZipInputStream对象，可以利用该类的getNextEntry()方法依次拿到每一个ZipEntry对象
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(
				zipFile), Charset.forName("GBK"));
		ZipEntry zipEntry = null;
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			String fileName = zipEntry.getName();
			File temp = new File(dir, fileName);
			if (zipEntry.isDirectory()) {
				temp.mkdirs();
			} else {
				temp.createNewFile();
			}
			if (temp.isFile()) {
				OutputStream os = new FileOutputStream(temp);
				// 通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
				InputStream is = zipFile1.getInputStream(zipEntry);
				int len = 0;
				while ((len = is.read()) != -1)
					os.write(len);
				os.close();
				is.close();
			}
		}
		zipInputStream.close();
	}

	public static void main(String[] args) throws Exception {
		//unzip(new File("F:/test/test.zip"), new File("F:/test"));
		zip(new File("F:/test/dic"), new File("F:/test/2.zip"));
	}
}
