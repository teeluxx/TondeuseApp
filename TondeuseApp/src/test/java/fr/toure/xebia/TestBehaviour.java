package fr.toure.xebia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import fr.toure.xebia.business.Appareil;
import fr.toure.xebia.model.Orientation;

public class TestBehaviour implements TestExecutionListener{

	@Autowired
	private Appareil tondeuse;
	
	public void afterTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterTestMethod(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void beforeTestClass(TestContext arg0) throws Exception {
		
	}

	public void beforeTestMethod(TestContext arg0) throws Exception {
		tondeuse.setOrientation(Orientation.NORTH);
	}

	public void prepareTestInstance(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
