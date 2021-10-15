package org.cadixdev.mercury.util;

import java.util.ArrayList;
import java.util.List;

import org.cadixdev.mercury.jdt.internal.compiler.batch.FileSystem;

public class ClasspathSectionProblemReporterTree implements FileSystem.ClasspathSectionProblemReporter {
	final List<String> invalid = new ArrayList<>(), multiple = new ArrayList<>();

	@Override
	public void invalidClasspathSection(String jarFilePath) {
		this.invalid.add(jarFilePath);
	}

	@Override
	public void multipleClasspathSections(String jarFilePath) {
		this.multiple.add(jarFilePath);
	}

	public void accept(FileSystem.ClasspathSectionProblemReporter reporter) {
		this.invalid.forEach(reporter::invalidClasspathSection);
		this.multiple.forEach(reporter::multipleClasspathSections);
	}

	public void clear() {
		this.invalid.clear();
		this.multiple.clear();
	}
}
