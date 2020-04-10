import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

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
    public void test4() {
        FileChannel channel1 = null;
        FileChannel channel2 = null;
        try {
            //分散读取
            RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
            channel1 = raf1.getChannel();

            ByteBuffer buf1 = ByteBuffer.allocate(100);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);

            ByteBuffer[] bufs = {buf1, buf2};
            channel1.read(bufs);

            for (ByteBuffer byteBuffer : bufs) {
                byteBuffer.flip();
            }

            System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
            System.out.println("----------------------------------");
            System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

            //聚集写入
            RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
            channel2 = raf2.getChannel();
            channel2.write(bufs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel1 != null) {
                try {
                    channel1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel2 != null) {
                try {
                    channel2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5(){
        Map<String,Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String,Charset>> set = map.entrySet();

        for (Map.Entry<String,Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
