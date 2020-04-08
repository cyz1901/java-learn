import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {
    @Test
    public void test1(){
        String str = "abcde";
        //System.out.println("hello world");
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.mark());
        System.out.println(buf.capacity());

        buf.put(str.getBytes());
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.mark());
        System.out.println(buf.capacity());
    }
}
