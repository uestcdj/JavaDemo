//package Undertow;
//
//import java.io.IOException;
//import java.nio.ByteBuffer;
//
//import org.xnio.BufferAllocator;
//import org.xnio.ByteBufferSlicePool;
//import org.xnio.OptionMap;
//import org.xnio.Options;
//import org.xnio.Pool;
//import org.xnio.Xnio;
//import org.xnio.XnioWorker;
//
//public class WriteDemo {
//
//	public static void main(String[] args) {
//		Xnio xnio = Xnio.getInstance();
//		try {
//			XnioWorker worker = xnio.createWorker(OptionMap.builder()
//					.set(Options.WORKER_IO_THREADS, 3)
//					.set(Options.WORKER_TASK_CORE_THREADS, 8)
//					.set(Options.WORKER_TASK_MAX_THREADS, 8)
//					.set(Options.TCP_NODELAY, true).getMap());
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		OptionMap socketOptions = OptionMap.builder()
//				.set(Options.WORKER_IO_THREADS, 3)
//				.set(Options.TCP_NODELAY, true)
//				.set(Options.REUSE_ADDRESSES, true)
//				.getMap();
//		
//		Pool<ByteBuffer> buffers = new ByteBufferSlicePool(BufferAllocator.DIRECT_BYTE_BUFFER_ALLOCATOR, bufferSize, maxRegionSize);
//	}
//
//}
