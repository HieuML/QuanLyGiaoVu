package StudentManager;

import java.util.Comparator;


public class DiemHbComparator implements Comparator<DiemHb>{

	@Override
	public int compare(DiemHb o1, DiemHb o2) {
		float GPA1 = o1.getGPA();
		float GPA2 = o2.getGPA();
		if(GPA1>GPA2)
			return -1;
		else if (GPA1 == GPA2)
			return 0;
		else 
			return 1;
	}
	
}