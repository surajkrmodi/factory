package com.sapient.attachments;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class AwsApplication {

	public static void main(String[] args) throws IOException {
		
        Regions clientRegion = Regions.US_EAST_1;
        String bucketName = "imageupload-suraj";
        String fileObjKeyName = "document\\demo.java";
        String fileName = "D:\\Users\\surmodi\\eclipse-workspace\\just\\src\\com\\sapient\\demo.java";
        AWSCredentials credentials = new BasicAWSCredentials(
        		  "<Access Key>", //access key
        		  "<Secret Key>" //secret key
        		);

        try {
            
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            		.withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(clientRegion)
                    .build();
            List<Bucket> buckets = s3Client.listBuckets();
            for(Bucket bucket : buckets) {
                System.out.println(bucket.getName());
            }
            
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("title", "someTitle");
            request.setMetadata(metadata); 
            s3Client.putObject(request);

        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
        	
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
        	
            e.printStackTrace();
        }
    }
}
