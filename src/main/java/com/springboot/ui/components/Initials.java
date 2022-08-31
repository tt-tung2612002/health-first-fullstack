package com.springboot.ui.components;

import com.springboot.ui.util.css.BorderRadius;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.springboot.ui.util.FontSize;
import com.springboot.ui.util.FontWeight;
import com.springboot.ui.util.LumoStyles;
import com.springboot.ui.util.UIUtils;

public class Initials extends FlexBoxLayout {

	private String CLASS_NAME = "initials";

	public Initials(String initials) {
		setAlignItems(FlexComponent.Alignment.CENTER);
		setBackgroundColor(LumoStyles.Color.Contrast._10);
		setBorderRadius(BorderRadius.L);
		setClassName(CLASS_NAME);
		UIUtils.setFontSize(FontSize.S, this);
		UIUtils.setFontWeight(FontWeight._600, this);
		setHeight(LumoStyles.Size.M);
		setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
		setWidth(LumoStyles.Size.M);

		add(initials);
	}

}
