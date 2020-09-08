package com.ma.petclinicdata.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.repository.OwnerRepository;

/**
 * The class <code>OwnerJPAServiceTest</code> contains tests for the class
 * <code>{@link OwnerJPAService}</code>.
 *
 * @generatedBy CodePro at 9/8/20 1:58 PM
 * @author manojkumara
 * @version $Revision: 1.0 $
 */
@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

	@Mock
	OwnerRepository ownerRepository;

	@InjectMocks
	OwnerJPAService ownerJPAService;

	Owner owner;

	final String LAST_NAME = "Ram";

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(new Long(3l)).lastName(LAST_NAME).build();
	}

	/**
	 * Run the OwnerJPAService(OwnerRepository) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testOwnerJPAService_1() throws Exception {
		OwnerJPAService result = new OwnerJPAService(ownerRepository);
		assertNotNull(result);
	}

	/**
	 * Run the void delete(Owner) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testDelete_1() throws Exception {
		this.ownerJPAService.delete(owner);

		Mockito.verify(this.ownerRepository, times(1)).delete(Mockito.any(Owner.class));

	}

	/**
	 * Run the void deleteById(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testDeleteById_1() throws Exception {
		this.ownerJPAService.deleteById(new Long(3l));

		Mockito.verify(this.ownerRepository, times(1)).deleteById(Mockito.anyLong());
	}

	/**
	 * Run the Set<Owner> findAll() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testFindAll_1() throws Exception {
		Set<Owner> result = new HashSet<>();
		result.add(owner);

		Mockito.when(this.ownerRepository.findAll()).thenReturn(result);

		Set<Owner> result1 = this.ownerJPAService.findAll();

		assertNotNull(result1);
	}

	/**
	 * Run the Owner findById(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testFindById_1() throws Exception {

		Mockito.when(this.ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(owner));

		Owner findById = this.ownerJPAService.findById(new Long(3l));
		assertNotNull(findById);
	}

	/**
	 * Run the Owner findByLastName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testFindByLastName_1() throws Exception {

		Mockito.when(this.ownerRepository.findByLastName(Mockito.anyString())).thenReturn(owner);
		
		Owner result = this.ownerJPAService.findByLastName(LAST_NAME);

		assertNotNull(result);

		assertEquals(LAST_NAME, result.getLastName());

		Mockito.verify(this.ownerRepository).findByLastName(Mockito.anyString());
	}

	/**
	 * Run the Owner save(Owner) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@Test
	void testSave_1() throws Exception {
		Mockito.when(this.ownerRepository.save(Mockito.any(Owner.class))).thenReturn(owner);
		
		Owner save = this.ownerJPAService.save(owner);
		
		assertNotNull(save);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 9/8/20 1:58 PM
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

}