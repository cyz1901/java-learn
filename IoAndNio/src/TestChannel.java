import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("1.jpeg");
            fos = new FileOutputStream("2.jpg");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) != -1){
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null){
                try{
                    outChannel.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
            if (inChannel != null){
                try{
                    inChannel.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
            if (fos != null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
            if (fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        }

    }

    @Test
    public void test2(){
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("1.jpeg"), StandardOpenOption.READ);
            outChannel= FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
            //内存映射文件
            MappedByteBuffer inMapperbuf =inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
            MappedByteBuffer outMapperbuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

            //直接对缓冲区进行操作
            byte[] dst = new byte[inMapperbuf.limit()];
            inMapperbuf.get(dst);
            outMapperbuf.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null){
                try{
                    outChannel.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
            if (inChannel != null){
                try{
                    inChannel.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        }

    }

    @Test
    public void test3(){
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = FileChannel.open(Paths.get("1.jpeg"), StandardOpenOption.READ);
            outChannel= FileChannel.open(Paths.get("4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

            //inChannel.transferTo(0,inChannel.size() ,outChannel);
            outChannel.transferFrom(inChannel,0,inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null){
                try{
                    inChannel.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
            if (outChannel != null){
                try{
                    outChannel.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        }

    }

    @Test
    public void test4(){
        //RandomAccessFile raf1 = new RandomAccessFile("1.jpeg","rw");

        //ByteBuffer buf1 = ByteBuffer.allocate(100);
        //ByteBuffer buf2 = ByteBuffer.allocate(1024);
    }
}
