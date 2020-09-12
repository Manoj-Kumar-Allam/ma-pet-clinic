package com.ma.petclinicweb.controllers;

import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ma.petclinicdata.model.Owner;
import com.ma.petclinicdata.services.OwnerService;

/**
 * The class <code>OwnerControllerTest</code> contains tests for the class <code>{@link OwnerController}</code>.
 *
 * @generatedBy CodePro at 9/8/20 3:31 PM, using the Spring generator
 * @author manojkumara
 * @version $Revision: 1.0 $
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;
	
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception if the initialization fails for some reason
	 *
	 * @see TestCase#setUp()
	 *
	 * @generatedBy CodePro at 9/8/20 3:11 PM
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.owners = new HashSet<>();
		this.owners.add(Owner.builder().id(new Long(1l)).lastName("Man").build());
		this.owners.add(Owner.builder().id(new Long(2l)).lastName("Ram").build());
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.ownerController).build();
	}
	
	/**
	 * Run the String find() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 3:31 PM
	 */
	/*@SuppressWarnings("deprecation")
	@Test
	void testFind_1()
		throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/owners/find")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("notimplemented"));
		verifyZeroInteractions(this.ownerService);
	}*/

	/**
	 * Run the String listOwners(Model) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/8/20 3:31 PM
	 */
	/*@Test
	void testListOwners_1()
		throws Exception {
		Mockito.when(this.ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(MockMvcRequestBuilders.get("/owners")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("owners/index")).andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
	}*/
	
	@SuppressWarnings("deprecation")
	@Test
	void testFind_1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/owners/find")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("owners/findOwners")).andExpect(MockMvcResultMatchers.model().attributeExists("owner"));
		verifyZeroInteractions(this.ownerService);
	}
	
	@Test
	void testProcessFindForm_1_ForOne() throws Exception {
		Owner build = Owner.builder().id(1l).lastName("Kumar").build();
		List<Owner> list = new ArrayList<>();
		list.add(build);
		Mockito.when(this.ownerService.findAllByLastNameLike(Mockito.anyString())).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders.get("/owners")).andExpect(MockMvcResultMatchers.status().is3xxRedirection()).andExpect(MockMvcResultMatchers.view().name("redirect:/owners/1"));
	}
	
	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception if the clean-up fails for some reason
	 *
	 * @see TestCase#tearDown()
	 *
	 * @generatedBy CodePro at 9/8/20 3:11 PM
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
}