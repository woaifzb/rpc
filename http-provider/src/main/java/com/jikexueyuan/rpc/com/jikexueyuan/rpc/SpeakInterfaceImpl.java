package com.jikexueyuan.rpc.com.jikexueyuan.rpc;

import com.jikexueyuan.rpc.People;
import com.jikexueyuan.rpc.SpeakInterface;
import org.springframework.stereotype.Component;

/**
 * Created by version_z on 2015/8/22.
 */
@Component("speakInterface")
public class SpeakInterfaceImpl implements SpeakInterface
{
    public String speak(People people)
    {
        if (people.getAge() > 18)
        {
            if (people.getSex() == 0)
            {
                return "男 "+people.getAge()+"岁";
            }else
            {
                return "女  "+people.getAge()+"岁";
            }
        }
        else
        {
            return "未成年小朋友";
        }
    }

	@Override
	public String speak(String hear) {
		// TODO Auto-generated method stub
		return "I hear you say "+hear;
	}
}
