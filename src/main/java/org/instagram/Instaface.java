package org.instagram;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.apache.http.HttpHost;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUploadVideoRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramLoginResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

/*
 * https://www.androidtipster.com/instagram-limits/
 */
public class Instaface {
	Instagram4j instagram;

	public void login(String user, String password) {
		instagram = Instagram4j.builder().username(user).password(password)
				.build();
		instagram.setup();
		try {
			InstagramLoginResult instagramLoginResult = instagram.login();
			if (Objects.equals(instagramLoginResult.getStatus(), "ok")) {
				System.out.println("login success");
			} else {
				instagram = null;
				return;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			instagram = null;
		}

		System.out.println("Check user leopardogeo");
		InstagramSearchUsernameResult userResult;
		try {
			userResult = instagram
					.sendRequest(new InstagramSearchUsernameRequest(
							"leopardageo"));
			System.out.println("ID for @leopardageo is "
					+ userResult.getUser().getPk());
			System.out.println("Number of followers: "
					+ userResult.getUser().getFollower_count());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginWithProxy(String user, String password, String protocol, int port, String host) {
		
		HttpHost proxy = new HttpHost(host, port, protocol);
		
		instagram = Instagram4j.builder().username(user).password(password).proxy(proxy)
				.build();
		instagram.setup();
		try {
			InstagramLoginResult instagramLoginResult = instagram.login();
			if (Objects.equals(instagramLoginResult.getStatus(), "ok")) {
				System.out.println("login success");
			} else {
				instagram = null;
				return;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			instagram = null;
		}

		System.out.println("Check user leopardogeo");
		InstagramSearchUsernameResult userResult;
		try {
			userResult = instagram
					.sendRequest(new InstagramSearchUsernameRequest(
							"leopardageo"));
			System.out.println("ID for @leopardageo is "
					+ userResult.getUser().getPk());
			System.out.println("Number of followers: "
					+ userResult.getUser().getFollower_count());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String uploadVideo(String fileName, String caption) {
		if (instagram == null) {
			return "Not logged in";
		}

		try {
			instagram.sendRequest(new InstagramUploadVideoRequest(new File(
					fileName), caption));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}

		return "Video uploaded successfully";
	}

	/*
	 * System.out.println("Check user leopardogeo");
	 * InstagramSearchUsernameResult userResult = instagram .sendRequest(new
	 * InstagramSearchUsernameRequest("leopardageo"));
	 * System.out.println("ID for @leopardageo is " +
	 * userResult.getUser().getPk()); System.out.println("Number of followers: "
	 * + userResult.getUser().getFollower_count());
	 * 
	 * InstagramGetUserFollowersResult githubFollowers =
	 * instagram.sendRequest(new
	 * InstagramGetUserFollowersRequest(userResult.getUser().getPk()));
	 * List<InstagramUserSummary> users = githubFollowers.getUsers(); for
	 * (InstagramUserSummary user : users) { System.out.println("User " +
	 * user.getUsername() + " follows leopardo!"); } } catch
	 * (ClientProtocolException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 */

}
