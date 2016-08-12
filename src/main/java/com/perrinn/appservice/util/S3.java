package com.perrinn.appservice.util;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3 {

	private AmazonS3 s3Client;
	private String bucketName;

	private void initLocals() {
		Config conf = new Config();
		if(conf.getDatabaseName() != null) {
			this.bucketName = conf.getBucketName();
		}
	}

	public S3() {
		this.initLocals();
		this.s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
	}

	public String getObjectFromStore(String bucketName, String objectName) {
		File  tmpFile = null;
		String tmpName = null;

		try {
			tmpFile = File.createTempFile("app", "tmp", new File("/tmp"));
			tmpName = tmpFile.getAbsolutePath();
			
			S3Object object = s3Client.getObject( new GetObjectRequest(bucketName, objectName));
			InputStream objectData = object.getObjectContent();
			// Process the objectData stream.
			objectData.close();
			GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, objectName);
			rangeObjectRequest.setRange(0, 10);
            S3Object objectPortion = s3Client.getObject(rangeObjectRequest);

            // Now stream the contents into our file
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
		}

		return tmpName;
	}
}