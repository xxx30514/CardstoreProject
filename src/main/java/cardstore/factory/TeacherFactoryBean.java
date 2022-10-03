package cardstore.factory;

import org.springframework.beans.factory.FactoryBean;

import cardstore.pojo.Teacher;
/*FactoryBean是一個介面 需要實現類
 * getObject 將方法返回值的物件交給IOC管理  return new Teacher(); 即將Teacher類交給IOC容器管理
 * getObjectType:設置所提供物件的類型
*/
public class TeacherFactoryBean implements FactoryBean<Teacher>{

	@Override
	public Teacher getObject() throws Exception {
		
		return new Teacher();
	}

	@Override
	public Class<?> getObjectType() {
	
		return Teacher.class;
	}
	
}
