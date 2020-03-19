package com.nuc.register;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private String[] groupNames;
    private String[][] childNames;

    public ExpandableListAdapter(Context context, String[] groupNames,
                                 String[][] childNames) {
        this.context = context;
        this.groupNames = groupNames;
        this.childNames = childNames;
    }

    /**
     * 获取孩子的内容
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childNames[groupPosition][childPosition];
    }

    /**
     * 返回孩子的id
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * 孩子的布局视图
     */
    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item_child, null);
        TextView tv_child = (TextView) view.findViewById(R.id.tv_child);
        tv_child.setText(childNames[groupPosition][childPosition]);
        return view;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item_group, null);
        TextView tv_group = (TextView) view.findViewById(R.id.tv_group);
        tv_group.setText(groupNames[groupPosition]);
        return view;
    }

    /**
     * 返回每一组孩子的个数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        // 先获取孩子所在数组，然后获取每一组的长度
        return childNames[groupPosition].length;
    }

    /**
     * 返回组的内容
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupNames[groupPosition];
    }

    /**
     * 获取组的个数
     */
    @Override
    public int getGroupCount() {
        return groupNames.length;
    }

    /**
     * 获取组的id
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 是否有唯一的id
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 孩子是否可选
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
