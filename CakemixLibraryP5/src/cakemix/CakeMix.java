/* CakeMix Processing Library!
 * Daniel Shiffman
 * Fall 2011 for ICM
 * designed for use with: http://www.itpcakemix.com/
 */

package cakemix;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import processing.core.PApplet;

public class CakeMix {

	PApplet parent;

	public static String url = "http://www.itpcakemix.com/";

	String user = "";
	String project = "";

	// For posting
	private Post post;
	
	private JSONArray data;

	public CakeMix(PApplet p, String u, String proj) {
		parent = p;
		user = u;
		project = proj;
	}

	
	public void addData(String key, Object values) {
		JSONArray jsonA = new JSONArray();
		jsonA.put(values);
		System.out.println(jsonA.toString());
		
		
		  /*String result = "[";

		  for (int i = 0; i < values.length; i++) {
		    if (i == values.length - 1) {
		      result += ""+values[i];
		    } 
		    else {
		      result += values[i] + ",";
		    }
		  }

		  result += "]";
		  addData(key, result);*/
		}
	
	
	public void addData(String key, int value) {
		addData(key,""+value);
	}

	public void addData(String key, String value) {
		if (key.equals("user") || key.equals("project")) {
			System.out.println("skipping, user and project are added automatically.");
			return;
		}

		if (post == null) {
			post = new Post(url + "add");
		}
		post.addData(key,value);
	}

	public void post() {
		if (post == null) {
			post = new Post(url + "add");
		}
		post.addData("user",user);
		post.addData("project",project);
		post.post();
	}

	public int getTotal() {
		if (data == null) {
			retrieve();
		}
		return data.length();
	}
	
	public String get(int i, String name) {
		if (data == null) {
			retrieve();
		}
		try {
			JSONObject element = data.getJSONObject(i);
			return element.getString(name);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "JSON parsing error";
	}
	
	public void reloadData() {
		retrieve();
	}
	
	
	private void retrieve() {
		// http://www.itpcakemix.com/project/icm/user/shiffman/
		String request = url + "project/" + project + "/user/" + user;
		System.out.println("Making request to: " + request);
		String[] lines = parent.loadStrings(request);
		String json = PApplet.join(lines,"");
		//System.out.println(json);
		try {
			data = new JSONArray(json);
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("There was an error parsing the JSONObject.");
		}
	}
	
}




