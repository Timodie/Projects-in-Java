package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {	
	public Queue<File>queue;
	private File root;
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		
	if((!rootNode.isDirectory() &&!rootNode.isFile())){
		throw new FileNotFoundException("file not found");
	}
	else{
		root = rootNode;
		queue = new Queue<File>();
		queue.enqueue(root);
	}
	}
	
	
	@Override
	public boolean hasNext() {
		// TODO 2\

	return !(queue.isEmpty()||queue.peek()==null);
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		if(!root.exists())
		throw new NoSuchElementException("Rootnode Doesn't exist");
		
		if(queue.isEmpty()){
			throw new  NoSuchElementException("empty");
		}
		
		else{
		
		
			File dequed = queue.dequeue();
		if(dequed.isDirectory()==true)
		//System.out.print(dequed.listFiles());	
			for(File i:dequed.listFiles())
			//while(dequed.listFiles() != null){
				queue.enqueue(i);
			//}
		//queue.printQueue();
		return dequed;
	}
	}
		

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
