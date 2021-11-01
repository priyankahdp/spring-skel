package com.cepheid.cloud.skel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cepheid.cloud.skel.exception.IncorrectStateException;
import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.service.ItemService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemControllerTest extends TestBase {

	@Autowired
	private ItemService mItemService;

	@Test
	public void save_item_test() throws IncorrectStateException {

		List<Description> descriptions = new ArrayList<Description>();
		Description description1 = new Description("series-1");
		descriptions.add(description1);

		Item item = new Item();
		item.setId(300L);
		item.setName("Lord of the rings");
		item.setBarcode(21316);
		item.setDescriptions(descriptions);
		item.setState("undefined");// undefined, valid, invalid

		mItemService.saveOrUpdate(item);

		assertThat(item).hasFieldOrPropertyWithValue("name", "Lord of the rings");
		assertThat(item).hasFieldOrPropertyWithValue("barcode", 21316);
		assertThat(item).hasFieldOrPropertyWithValue("state", "undefined");
	}

	//@Test
	//public void testGetItems() throws Exception {
		// Builder itemController = getBuilder("/app/api/1.0/items");
		// Collection<Item> items = itemController.get(new
		// GenericType<Collection<Item>>() {});

	//}
}
