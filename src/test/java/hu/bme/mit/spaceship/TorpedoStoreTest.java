package hu.bme.mit.spaceship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorpedoStoreTest {

	@Test
	void fire_Success(){
		// Arrange
		TorpedoStore store = new TorpedoStore(1);

		// Act
		boolean result = store.fire(1);

		// Assert
		assertTrue(result);
		assertEquals(0, store.getTorpedoCount());
	}

	@Test
	void cannotFireEmpty () {

		TorpedoStore store = new TorpedoStore(0);

		// Act
		assertThrows(IllegalArgumentException.class, () -> store.fire(1));
	}

	@Test
	void cannotFireMore () {

		TorpedoStore store = new TorpedoStore(10);

		assertThrows(IllegalArgumentException.class, () -> store.fire(  11));
	}

	@Test
	void fails () {

		TorpedoStore store = new TorpedoStore(10, 1);

		// Act
		boolean result = store.fire(1);

		// Assert
		assertFalse(result);
	}
}
