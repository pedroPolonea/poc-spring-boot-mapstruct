package com.example.mapstruct;

import com.example.mapstruct.entity.Author;
import com.example.mapstruct.mapper.AuthorMapper;
import com.example.mapstruct.vo.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {
	@Autowired
	private AuthorMapper authorMapper;

	private Author author;

	private static final Long ID = 1L;
	private static final String FIRST_NAME = "Paulo";
	private static final String LAST_NAME = "Silva";

	@Before
	public  void setUp(){
		author = new Author();
		author.setId(ID);
		author.setFirstName(FIRST_NAME);
		author.setLastName(LAST_NAME);
	}

	@Test
	public void shouldReturnAuthorDefaultVO() {
		AuthorDefaultVO authorDefaultVO;

		authorDefaultVO = authorMapper.authorToAuthorDefaultVO(author);

		Assert.assertThat(authorDefaultVO.getId(), CoreMatchers.is(author.getId()));
		Assert.assertThat(authorDefaultVO.getFirstName(), CoreMatchers.is(author.getFirstName()));
		Assert.assertThat(authorDefaultVO.getLastName(), CoreMatchers.is(author.getLastName()));
	}

	@Test
	public void shouldReturnAuthorDefaultVOToAuthor() {
		AuthorDefaultVO authorDefaultVO = new AuthorDefaultVO();
		authorDefaultVO.setId(ID);
		authorDefaultVO.setFirstName(FIRST_NAME);
		authorDefaultVO.setLastName(LAST_NAME);

		author = authorMapper.authorDefaultVOToAuthor(authorDefaultVO);

		Assert.assertThat(author.getId(), CoreMatchers.is(authorDefaultVO.getId()));
		Assert.assertThat(author.getFirstName(), CoreMatchers.is(authorDefaultVO.getFirstName()));
		Assert.assertThat(author.getLastName(), CoreMatchers.is(authorDefaultVO.getLastName()));
	}

	@Test
	public void shouldReturnAuthorDifferentAttributesVO() {
		AuthorDifferentAttributesVO authorVO;

		authorVO = authorMapper.authorToAuthorDifferentAttributesVO(author);

		Assert.assertThat(authorVO.getIdAuthor(), CoreMatchers.is(author.getId()));
		Assert.assertThat(authorVO.getFirstNameAuthor(), CoreMatchers.is(author.getFirstName()));
		Assert.assertThat(authorVO.getLastName(), CoreMatchers.is(author.getLastName()));
	}

	@Test
	public void shouldReturnAuthorDifferentAttributesVOToAuthor () {
		AuthorDifferentAttributesVO authorVO = new AuthorDifferentAttributesVO();
		authorVO.setIdAuthor(ID);
		authorVO.setFirstNameAuthor(FIRST_NAME);
		authorVO.setLastName(LAST_NAME);


		author = authorMapper.authorDifferentAttributesVOToAuthor(authorVO);

		Assert.assertThat(author.getId(), CoreMatchers.is(authorVO.getIdAuthor()));
		Assert.assertThat(author.getFirstName(), CoreMatchers.is(authorVO.getFirstNameAuthor()));
		Assert.assertThat(author.getLastName(), CoreMatchers.is(authorVO.getLastName()));
	}

	@Test
	public void shouldReturnAuthorSynthesisVO() {
		AuthorSynthesisVO authorVO;

		authorVO = authorMapper.authorToAuthorSynthesisVO(author);

		Assert.assertThat(authorVO.getId(), CoreMatchers.is(author.getId()));
		Assert.assertThat(authorVO.getName(), CoreMatchers.is(author.getFirstName().concat(" ").concat(author.getLastName())));
	}

	@Test
	public void shouldReturnAuthorSynthesisVOToAuthorVO() {
		AuthorSynthesisVO authorVO = new AuthorSynthesisVO();
		authorVO.setId(ID);
		authorVO.setName(FIRST_NAME.concat(" ").concat(LAST_NAME));

		author = authorMapper.authorSynthesisVOToAuthor(authorVO);

		Assert.assertThat(author.getId(), CoreMatchers.is(authorVO.getId()));
		Assert.assertThat(author.getFirstName(), CoreMatchers.nullValue());
		Assert.assertThat(author.getLastName(), CoreMatchers.nullValue());
	}

	@Test
	public void shouldReturnAuthorNullDefaultVO() {
		AuthorDefaultVO authorDefaultVO;

		authorDefaultVO = authorMapper.authorNullToAuthorDefaultVO(new Author());

		Assert.assertThat(authorDefaultVO.getId(), CoreMatchers.nullValue());
		Assert.assertThat(authorDefaultVO.getFirstName(), CoreMatchers.is("Default"));
		Assert.assertThat(authorDefaultVO.getLastName(), CoreMatchers.is("Default"));
	}

	@Test
	public void shouldReturnAuthorSynthesisExpressionJavaVO() {
		AuthorSynthesisExpressionJavaVO authorSynthesisExpressionJavaVO;
		author.setFirstName(null);

		authorSynthesisExpressionJavaVO = authorMapper.authorToAuthorSynthesisExpressionJavaVO(author);

		Assert.assertThat(authorSynthesisExpressionJavaVO.getId(), CoreMatchers.is(author.getId()));
		Assert.assertThat(authorSynthesisExpressionJavaVO.getName(), CoreMatchers.is(author.getLastName()));
	}

	@Test
	public void shouldReturnAuthorSynthesisExpressionImplicitVO() {
		AuthorSynthesisExpressionImplicitVO authorSynthesisExpressionImplicitVO;
		author.setFirstName(null);

		authorSynthesisExpressionImplicitVO = authorMapper.authorToAuthorSynthesisExpressionImplicitVO(author);

		Assert.assertThat(authorSynthesisExpressionImplicitVO.getId(), CoreMatchers.is(author.getId()));
		Assert.assertThat(authorSynthesisExpressionImplicitVO.getName(), CoreMatchers.is(author.getLastName()));
	}

}
