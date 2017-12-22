package cn.migu.tasklet;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import cn.migu.domain.Student;


@Component("csvItemProcessor")
public class CsvItemProcessor  implements ItemProcessor<Student, Student>{

	/**
	 * 对取到的数据进行简单的处理。
	 */
	public Student process(Student student) throws Exception {
		/* 合并ID和名字 */
        student.setName(student.getID() + "--" + student.getName());
        /* 年龄加2 */
        student.setAge(student.getAge() + 2);
        /* 分数加10 */
        student.setScore(student.getScore() + 10);
        /* 将处理后的结果传递给writer */
        System.out.println("CsvItemProcessor处理了，student:"+student.getName());
        return student;
	}

}
