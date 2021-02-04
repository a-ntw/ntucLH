package com.ntuc.model;

public class Node {

    private String nodeId; // node id
    private String pid; // parent id
    private String text;
    private String href;

    public Node(String nodeId, String pId, String text, String href) {
        this.nodeId = nodeId;
        this.pid = pId;
        this.text = text;
        this.href = href;
        
        
    }

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
