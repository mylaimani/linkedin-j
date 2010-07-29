/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nabeel Mukhtar
 *
 */
public enum ProfileField implements CompositeEnum<ProfileField> {

    /**
     * the member token for this member
     */
    ID("id", true),

    /**
     * the member's first name
     */
    FIRST_NAME("first-name", true),

    /**
     * the member's last name
     */
    LAST_NAME("last-name", true),

    /**
     * the member's headline (often "Job Title at Company")
     */
    HEADLINE("headline", true),

    /**
     * Generic name of the location of the LinkedIn member, (ex: "San Francisco Bay Area")
     */
    LOCATION("location", true),
    
    /**
     * Generic name of the location of the LinkedIn member, (ex: "San Francisco Bay Area")
     */
    LOCATION_NAME("location:(name)", true),

    /**
     * country code for the LinkedIn member
     */
    LOCATION_COUNTRY_CODE("location:(country:(code))", true),

    /**
     * the industry the LinkedIn member has indicated their profile belongs to
     */
    INDUSTRY("industry", true),

    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    DISTANCE("distance", false),

    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    RELATION_TO_VIEWER("relation-to-viewer", false),
    
    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    RELATION_TO_VIEWER_DISTANCE("relation-to-viewer:(distance)", false),

    RELATION_TO_VIEWER_RELATED_CONNECTIONS("relation-to-viewer:(related-connections)", false),
    
    /**
     * a total attribute will denote the number of connections that link the fetching member to the fetched. Contains brief connection/person objects indicating the connecting first degree members.
     */
    RELATION_TO_VIEWER_CONNECTIONS("relation-to-viewer:(num-related-connections)", false),

    /**
     * the member's current status, if set
     */
    CURRENT_STATUS("current-status", true),

    /**
     * the timestamp, in milliseconds, when the member's status was last set
     */
    CURRENT_STATUS_TIMESTAMP("current-status-timestamp", true),

    /**
     * an empty collection, indicating the # of connections the member has with a total attribute.
     */
    CONNECTIONS("connections", false),
    
    NUM_CONNECTIONS("num-connections", true),
    
    NUM_CONNECTIONS_CAPPED("num-connections-capped", true),

    /**
     * A long-form text area where the member describes their professional profile
     */
    SUMMARY("summary", false),

    /**
     * A short-form text area where the member enumerates their specialties.
     */
    SPECIALTIES("specialties", false),

    /**
     * A short-form text area describing how the member approaches proposals
     */
    PROPOSAL_COMMENTS("proposal-comments", false),

    /**
     * A short-form text area enumerating the Associations a member has
     */
    ASSOCIATIONS("associations", false),

    /**
     * A short-form text area describing what Honors the member may have
     */
    
    HONORS("honors", false),

    INTERESTS("interests", true),
    
    /**
     * A collection of positions a member has had, the total indicated by a total attribute
     */
    POSITIONS("positions", true),

    /**
     * A collection of education institutions a member has attended, the total indicated by a total attribute
     */
    EDUCATIONS("educations", true),

    /**
     * A collection of positions a member currently holds, limited to three and indicated by a total attribute
     */
    THREE_CURRENT_POSITIONS("three-current-positions", true),
    
    /**
     * A collection of positions a member formerly held, limited to the three most recent and indicated by a total attribute
     */
    THREE_PAST_POSITIONS("three-past-positions", true),
    
    NUM_RECOMMENDERS("num-recommenders", true),
    
    RECOMMENDATIONS_RECEIVED("recommendations-received", true),
    
    /**
     * a collection of phone numbers
     */
    PHONE_NUMBERS("phone-numbers", true),
    
    /**
     * a collection of instant messenger accounts
     */
    IM_ACCOUNTS("im-accounts", true),

    /**
     * a collection of twitter accounts
     */
    TWITTER_ACCOUNTS("twitter-accounts", true),

    /**
     * member's birth date
     */
    DATE_OF_BIRTH("date-of-birth", true),

    /**
     * address
     */
    MAIN_ADDRESS("main-address", true),
    
    /**
     * A collection of URLs the member has chosen to share on their LinkedIn profile
     */
    MEMBER_URL_RESOURCES("member-url-resources", true),

    /**
     * The fully-qualified URL being shared
     */
    MEMBER_URL_URL("member-url:(url)", false),

    /**
     * The label given to the URL by the member
     */
    MEMBER_URL_NAME("member-url:(name)", false),
    
    /**
     * A URL to the profile picture, if the member has associated one with their profile and it is visible to the requestor
     */
    PICTURE_URL("picture-url", true),

    /**
     * the URL to the member's authenticated profile on LinkedIn (requires a login to be viewed, unlike public profiles)
     */
    SITE_STANDARD_PROFILE_REQUEST("site-standard-profile-request:(url)", true),
    

    /**
     * An URL representing the resource you would request for programmatic access to the member's public profile
     */
    API_PUBLIC_PROFILE_REQUEST("api-public-profile-request:(url)", true),
    
    /**
     * An URL representing the resource you would request for programmatic access to the member's public profile
     */
    SITE_PUBLIC_PROFILE_REQUEST("site-public-profile-request:(url)", true),

    /**
     * An URL representing the resource you would request for programmatic access to the member's profile
     */
    API_STANDARD_PROFILE_REQUEST("api-standard-profile-request:(url)", true),
    
    /**
     * A collection of fields that can be re-used as HTTP headers to request an out of network profile programmatically
     */
    API_STANDARD_PROFILE_REQUEST_HEADERS("api-standard-profile-request:(headers)", true),

    /**
     * 	A URL to the member's public profile, if enabled.
     */
    PUBLIC_PROFILE_URL("public-profile-url", true);
    
    /**
     * Field Description.
     */
	private static final Map<String, ProfileField> stringToEnum = new HashMap<String, ProfileField>();

	static { // Initialize map from constant name to enum constant
		for (ProfileField op : values()) {
			stringToEnum.put(op.fieldName(), op);
		}
	}
    
    /** Field description */
    private final String fieldName;

    /** Field description */
    private final boolean availableForConnections;
    
    /**
     * Constructs ...
     *
     *
     * @param name
     */
    ProfileField(String name, boolean availableForConnections) {
        this.fieldName = name;
        this.availableForConnections = availableForConnections;
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.client.enumeration.FieldEnum#fieldName()
	 */
    public String fieldName() {
        return this.fieldName;
    }

    /** 
	 * 
	 */
    public boolean isAvailableForConnections() {
        return this.availableForConnections;
    }
    
    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

	/**
	 *
	 * @return Returns ProfileField for string, or null if string is invalid
	 */
	public static FieldEnum fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
	
	/**
	 *
	 * @return Returns ProfileFields available for connections.
	 */
	public static Set<ProfileField> valuesForConnections() {
		final Set<ProfileField> valuesForConnections = new HashSet<ProfileField>();
		for (ProfileField field : values()) {
			if (field.isAvailableForConnections()) {
				valuesForConnections.add(field);
			}
		}
		return valuesForConnections;
	}

	@Override
	public ProfileField parent() {
		return null;
	}
}
