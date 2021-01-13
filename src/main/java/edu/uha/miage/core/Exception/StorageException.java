package edu.uha.miage.core.Exception;

/**
 *
 * @author Psyrkoz
 */
public class StorageException extends RuntimeException {
	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}