package com.example.data;

import java.util.ArrayList;
import java.util.List;

import com.example.menu.R;

public class linkToLogo {
	public int getImage(String imageName)
	{
		List<ImageInfo> list = new ArrayList<ImageInfo>();
		list.add(new ImageInfo("image1", R.drawable.image1));
		list.add(new ImageInfo("image2", R.drawable.image2));
		list.add(new ImageInfo("image3", R.drawable.image3));
		list.add(new ImageInfo("image4", R.drawable.image4));
		list.add(new ImageInfo("image5", R.drawable.image5));
		list.add(new ImageInfo("image6", R.drawable.image6));
		list.add(new ImageInfo("image7", R.drawable.image7));
		list.add(new ImageInfo("image8", R.drawable.image8));
		list.add(new ImageInfo("image9", R.drawable.image9));
		int imageSource = 0;
		for(ImageInfo imageInfo : list)
		{
			if(imageInfo.imageName.equals(imageName))
			{
				imageSource = imageInfo.imageDrawable;
				break;
			}
		}
		if(imageSource == 0)
			imageSource = R.drawable.image1;
		return imageSource;
	}
	private class ImageInfo
	{
		public String imageName;
		public int imageDrawable; 
		public ImageInfo(String name, int drawable)
		{
			imageName = name;
			imageDrawable = drawable;
					
		}
	}
}
