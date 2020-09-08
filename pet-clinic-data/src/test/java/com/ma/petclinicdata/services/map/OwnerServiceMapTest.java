package com.ma.petclinicdata.services.map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.services.PetService;
import com.ma.petclinicdata.services.PetTypeService;
import com.ma.petclinicdata.services.map.OwnerServiceMap;
import com.ma.petclinicdata.services.map.PetServiceMap;
import com.ma.petclinicdata.services.map.PetTypeServiceMap;

/**
 * The class <code>OwnerServiceMapTest</code> contains tests for the class
 * <code>{@link OwnerServiceMap}</code>.
 *
 * @generatedBy CodePro at 9/8/20 11:28 AM
 * @author manojkumara
 * @version $Revision: 1.0 $
 */
class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;

	final Long ownerId = new Long(9l);

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
		this.ownerServiceMap.save(Owner.builder().id(ownerId).lastName("chinni").build());
	}

	/**
	 * Run the OwnerServiceMap(PetService,PetTypeService) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testOwnerServiceMap_1() throws Exception {

		PetService petService = new PetServiceMap();
		PetTypeService petTypeService = new PetTypeServiceMap();

		OwnerServiceMap result = new OwnerServiceMap(petService, petTypeService);

		assertNotNull(result);
	}

	/**
	 * Run the void delete(Owner) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testDelete_1() throws Exception {

		this.ownerServiceMap.delete(this.ownerServiceMap.findById(ownerId));

		assertEquals(0, this.ownerServiceMap.findAll().size());
	}

	/**
	 * Run the void deleteById(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	public void testDeleteById_1() throws Exception {
		
		Long id = new Long(1L);

		this.ownerServiceMap.save(Owner.builder().id(id).build());
		
		this.ownerServiceMap.deleteById(id);
		
		assertNull(this.ownerServiceMap.findById(id));

	}

	/**
	 * Run the Set<Owner> findAll() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testFindAll_1() throws Exception {
		this.ownerServiceMap.save(Owner.builder().id(new Long(19l)).build());
		Set<Owner> list = this.ownerServiceMap.findAll();
		assertNotNull(list);
		assertEquals(2, list.size());
	}

	/**
	 * Run the Owner findById(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testFindById_1() throws Exception {

		Owner findById = this.ownerServiceMap.findById(ownerId);
		assertEquals(9l, findById.getId());
	}

	/**
	 * Run the Owner findByLastName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testFindByLastName_1() throws Exception {
		
		this.ownerServiceMap.save(Owner.builder().lastName("Manoj").build());

		assertNotNull(this.ownerServiceMap.findByLastName("Manoj"));
	}
	
	/**
	 * Run the Owner findByLastName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testFindByLastName_2() throws Exception {
		
		this.ownerServiceMap.save(Owner.builder().lastName("Manoj").build());
		Owner findByLastName = ownerServiceMap.findByLastName("Ra");
		assertNull(findByLastName);
	}

	/**
	 * Run the Owner save(Owner) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testSave_1() throws Exception {
		Long id1 = new Long(2l);
		Owner owner2 = Owner.builder().id(id1).build();
		Owner save = this.ownerServiceMap.save(owner2);
		assertNotNull(save);
		assertEquals(id1, save.getId());
	}

	/**
	 * Run the Owner save(Owner) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@Test
	void testSave_2() throws Exception {
		Owner save = this.ownerServiceMap.save(Owner.builder().build());
		assertNotNull(save);
		assertNotNull(save.getId());
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 9/8/20 11:28 AM
	 */
	@AfterEach
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

}