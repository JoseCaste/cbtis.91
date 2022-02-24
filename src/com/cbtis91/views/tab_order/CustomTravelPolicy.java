package com.cbtis91.views.tab_order;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomTravelPolicy extends FocusTraversalPolicy{

	private Vector<Component> order;

	
	@Override
	public Component getComponentAfter(Container arg0, Component arg1) {
		int idx = (order.indexOf(arg1) + 1) % order.size();
        return order.get(idx);
	}

	@Override
	public Component getComponentBefore(Container arg0, Component arg1) {
		int idx = order.indexOf(arg1) - 1;
        if (idx < 0) {
            idx = order.size() - 1;
        }
        return order.get(idx);
	}

	@Override
	public Component getDefaultComponent(Container arg0) {
		// TODO Auto-generated method stub
		return order.get(0);
	}

	@Override
	public Component getFirstComponent(Container arg0) {
		// TODO Auto-generated method stub
		return order.lastElement();
	}

	@Override
	public Component getLastComponent(Container arg0) {
		// TODO Auto-generated method stub
		return order.get(0);
	}
	

}
