package FileHandling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * ============================================================
 * BufferedInputStream - Why Do We Need It?
 * ============================================================
 *
 * Problem with FileInputStream:
 * ----------------------------
 * Each call to read() may result in a system call to the
 * Operating System (OS).
 *
 * Example:
 *
 *     FileInputStream fis = new FileInputStream("input.txt");
 *
 *     int data;
 *     while((data = fis.read()) != -1) {
 *         // Process byte
 *     }
 *
 * If a file contains 10,00,000 bytes and we read it byte-by-byte,
 * read() will be called 10,00,000 times.
 *
 * This can potentially lead to 10,00,000 system calls.
 *
 *
 * What Happens During a System Call?
 * ----------------------------------
 * 1. Java program is executing in User Mode.
 * 2. read() is invoked.
 * 3. Control switches to OS Kernel Mode.
 * 4. OS performs the disk read operation.
 * 5. Control switches back to User Mode.
 *
 * This User Mode <-> Kernel Mode transition is called
 * a Context Switch.
 *
 *
 * Why Is This Expensive?
 * ----------------------
 * Context switching introduces overhead because:
 *
 * - CPU switches execution modes.
 * - OS performs disk I/O.
 * - Execution returns back to the application.
 *
 * Repeating this millions of times can significantly
 * impact performance.
 *
 *
 * Solution: BufferedInputStream
 * -----------------------------
 * BufferedInputStream maintains an internal memory buffer
 * (typically 8 KB).
 *
 * Instead of reading one byte from the disk for every
 * read() call, it performs the following:
 *
 * 1. Reads a large block of bytes from the file using
 *    a single system call.
 *
 * 2. Stores those bytes inside an internal buffer.
 *
 * 3. Subsequent read() calls return data directly from
 *    the buffer (RAM), without contacting the OS.
 *
 * 4. When the buffer becomes empty, another large block
 *    is loaded from the file.
 *
 *
 * Working Example:
 * ----------------
 *
 * Disk
 *   |
 *   |  (1 System Call)
 *   v
 * +------------------+
 * | Internal Buffer  |
 * +------------------+
 *   |    |    |    |
 *   v    v    v    v
 * read read read read
 *
 * Multiple read() operations are served from memory,
 * reducing the number of system calls.
 *
 *
 * Performance Benefit:
 * --------------------
 * File Size      : 10,00,000 bytes
 * Buffer Size    : 8,192 bytes
 *
 * Without Buffering:
 *     ~10,00,000 system calls
 *
 * With Buffering:
 *     10,00,000 / 8,192 ≈ 122 system calls
 *
 * This dramatically reduces context-switching overhead
 * and improves file I/O performance.
 *
 *
 * BufferedOutputStream:
 * ---------------------
 * BufferedOutputStream follows the same idea.
 *
 * Instead of writing every byte immediately to disk,
 * data is first stored in an internal buffer.
 *
 * The OS is contacted only when:
 * - The buffer becomes full.
 * - flush() is called.
 * - close() is called.
 *
 *
 * Key Takeaway:
 * -------------
 * Buffered streams improve performance by reducing the
 * number of expensive system calls and context switches
 * between User Mode and Kernel Mode.
 *
 * Memory access is much faster than disk access, so
 * reading/writing data in chunks is significantly more
 * efficient than processing one byte at a time.
 * ============================================================
 */

public class BufferInputStream_ {


    public static void main(String[] args) {

        try(BufferedInputStream bis =new BufferedInputStream(new FileInputStream("input.txt"))){

            // default size of internal buffer is 8092 bytes (8Kb) but we can declare our own size for internal buffer
        //    BufferedInputStream bis1=new BufferedInputStream(new FileInputStream("input.txt"),9000);


            int byteValeu;

            while((byteValeu=bis.read())!=-1){
                System.out.println((char)byteValeu);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
