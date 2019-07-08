public class ExampleControllerTest {
	private ExampleController subject;
	@Mock // 模拟器
	private PersonRepository personRepo;

	@Before // 在每个测试方法之前执行
	public void setUp() throws Exception {
		initMocks(this);
		subject = new ExampleController(personRepo);
	}

	@Test // 测试用例1
	public void shouldReturnFullNameOfAPerson() throws Exception {
		Person peter = new Person("东", "王");
		given(personRepo.findByLastName("王")).willReturn(Optional.of(东));
		String greeting = subject.hello("王");
		assertThat(greeting, is("你好王东!"));
	}

	@Test // 测试用例2
	public void shouldTellIfPersonIsUnknown() throws Exception {
		given(personRepo.findByLastName(anyString())).willReturn(Optional.empty());
		String greeting = subject.hello("王");
		assertThat(greeting, is("这位王先生是谁？"));
	}
}