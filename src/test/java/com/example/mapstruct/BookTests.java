package com.example.mapstruct;

import com.example.mapstruct.entity.Book;
import com.example.mapstruct.mapper.BookMapper;
import com.example.mapstruct.mapper.BookSynthesisMapper;
import com.example.mapstruct.vo.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {
	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private BookSynthesisMapper bookSynthesisMapper;

	private Book book;

	@Before
	public  void setUp(){
		book = new Book();
		book.setId(1L);
		book.setEdition(10);
		book.setIsbn("A123");
		book.setNumberPages(10);
		book.setTitle("Crowd Dance");
        book.setPublishingCompany("Dark Side Books");
	}

	@Test
	public void shouldReturnBookDefaultVO() {
		BookDefaultVO bookDefaultVO;

		bookDefaultVO = bookMapper.bookToBookDefaultVO(book);

		Assert.assertThat(bookDefaultVO.getId(), CoreMatchers.is(book.getId()));
		Assert.assertThat(bookDefaultVO.getEdition(), CoreMatchers.is(book.getEdition()));
		Assert.assertThat(bookDefaultVO.getIsbn(), CoreMatchers.is(book.getIsbn()));
		Assert.assertThat(bookDefaultVO.getNumberPages(), CoreMatchers.is(book.getNumberPages()));
		Assert.assertThat(bookDefaultVO.getTitle(), CoreMatchers.is(book.getTitle()));
	}

	@Test
	public void shouldUpdateBookDefaultVO() {
		BookDefaultVO bookDefaultVO;
		bookDefaultVO = bookMapper.bookToBookDefaultVO(book);
		Assert.assertThat(bookDefaultVO.getId(), CoreMatchers.is(book.getId()));

		book.setId(10L);
		bookMapper.updateBookDefaultVO(book, bookDefaultVO);
		Assert.assertThat(bookDefaultVO.getId(), CoreMatchers.is(book.getId()));
	}

	@Test
	public void shouldReturnBook() {
		BookDefaultVO bookDefaultVO;
		bookDefaultVO = bookMapper.bookToBookDefaultVO(book);
		Assert.assertThat(bookDefaultVO.getId(), CoreMatchers.is(book.getId()));

		Book bookLocal = bookMapper.bookDefaultVOToBook(bookDefaultVO);
		Assert.assertThat(bookLocal.getId() , CoreMatchers.is(bookDefaultVO.getId()));
	}

	@Test
	public void shouldReturnListBookDefaultVO() {
		List<BookDefaultVO> bookDefaultVOS;
		List<Book> books = Arrays.asList(new Book(1L), new Book(5L));
		bookDefaultVOS = bookMapper.bookListToBookDefaultVOList(books);

		Assert.assertThat(bookDefaultVOS.get(0).getId() , CoreMatchers.is(books.get(0).getId()));
		Assert.assertThat(bookDefaultVOS.get(1).getId() , CoreMatchers.is(books.get(1).getId()));
	}

    @Test
	public void shouldReturnBookSynthesisVOQualifierMontTitle() {
		BookSynthesisVO bookSynthesisVO;

		bookSynthesisVO = bookSynthesisMapper.bookToBookSynthesisVOQualifiedMountTitle(book);

		Assert.assertThat(bookSynthesisVO.getId() , CoreMatchers.is(book.getId()));
		Assert.assertThat(bookSynthesisVO.getTitle() , CoreMatchers.is(book.getTitle().concat(" - ").concat(book.getIsbn())));
	}

	@Test
	public void shouldReturnBookSynthesisVOCapitalizeTitle() {
		BookSynthesisVO bookSynthesisVO;

		bookSynthesisVO = bookSynthesisMapper.bookToBookSynthesisVOExternalCapitalizeTitle(book);

		Assert.assertThat(bookSynthesisVO.getId() , CoreMatchers.is(book.getId()));
		Assert.assertThat(bookSynthesisVO.getTitle() , CoreMatchers.is(StringUtils.capitalize(book.getTitle())));
	}

	@Test
	public void x() {
		BookSynthesisVO bookSynthesisVO;

		bookSynthesisVO = bookSynthesisMapper.bookToBookDefaultVODate(book);

		//Assert.assertThat(bookSynthesisVO.getChargeVO() , CoreMatchers.is(StringUtils.capitalize(book.getTitle())));
	}
}
