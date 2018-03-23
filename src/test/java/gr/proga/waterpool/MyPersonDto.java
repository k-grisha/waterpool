package gr.proga.waterpool;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

//@Builder
//@Value
@AllArgsConstructor
@ToString
public class MyPersonDto {
	private final String name;
	private final Integer age;
}

@Builder
class TestDto {
	@Builder.Default
	private  Integer age ;
	@Builder.Default
	private  String name ;

	@Builder(builderMethodName = "builderPersonDto")
	public MyPersonDto newPersonDto() {
		return new MyPersonDto(name, age);
	}

}

@Setter
@Accessors(chain = true)
class TestDtoBuilders {
	private static Integer age = 10;
	private static String name = "Default";

	public static MyPersonDto buildPerson() {
		return new MyPersonDto(name, age);
	}

}


class Main {

	public static void main(String[] args) {
//		MyPersonDto myPerson1 = new MyPersonDto("Ivan", 123);
//		System.out.println(myPerson1);

//		MyPersonDto myPerson2 = TestDto.builderPersonDto().build();



		MyPersonDto myPerson3 = TestDtoBuilders.buildPerson();
//		System.out.println(myPerson3);
		sun.security.util.Debug.Help();
	}
}


