package dev.doctor4t.mariposa.common;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

public interface MariposaService {
	MariposaService INSTANCE = ServiceLoader.load(MariposaService.class, MariposaService.class.getClassLoader()).findFirst().orElseThrow(() -> new NoSuchElementException("Unable to load %s service!".formatted(MariposaService.class.getName())));

	void initTerraBlender();
}
