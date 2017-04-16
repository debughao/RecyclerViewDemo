/* Copyright 2015 Luzhuo. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.debughao.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.debughao.recyclerview.R;



public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {
	private Context context;
	private boolean isVertical;
	private int[] imageContents;

	public ListAdapter(Context context, boolean isVertical, int[] imageContents) {
		this.context = context;
		this.isVertical = isVertical;
		this.imageContents = imageContents;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(isVertical ? R.layout.item_list : R.layout.item_list_h, parent, false);
		return new RecyclerHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		((RecyclerHolder) holder).setData(position);
	}

	@Override
	public int getItemCount() {
		return imageContents == null ? 0 : imageContents.length;
	}

	class RecyclerHolder extends RecyclerView.ViewHolder {
		private TextView text;
		private ImageView image;

		public RecyclerHolder(View itemView) {
			super(itemView);
			text = (TextView) itemView.findViewById(R.id.text);
			image = (ImageView) itemView.findViewById(R.id.image);
		}

		public void setData(int position) {
			text.setText("position:"+position);
			image.setImageResource(imageContents[position]);
		}
	}
}
