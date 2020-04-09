import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {
    @Test
    public void test1(){
        //分配一个缓冲区大小
        String str = "abcde";
        //System.out.println("hello world");
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //put 存数据
        buf.put(str.getBytes());
        System.out.println("------------------put----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //flip 改变为读数据模式
        buf.flip();
        System.out.println("------------------flip----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //get 取数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println("------------------get----------------");
        System.out.println(new String(dst,0,dst.length));
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //rewind 可重复读数据
        buf.rewind();
        System.out.println("------------------rewind----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //clear 清空缓冲区
        buf.clear();
        System.out.println("------------------clear----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

    }

    @Test
    public void test2(){
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buf.position());
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());

        buf.reset();
        System.out.println(buf.position());
    }
}
