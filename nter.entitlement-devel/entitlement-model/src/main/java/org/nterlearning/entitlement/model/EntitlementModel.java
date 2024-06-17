/**
 * National Training and Education Resource (NTER)
 * Copyright (C) 2012  SRI International
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package org.nterlearning.entitlement.model;

import org.nterlearning.xml.entitlement.domain_objects_0_1_0.Action;
import org.nterlearning.xml.entitlement.domain_objects_0_1_0.EntitlementPolicy;
import org.nterlearning.xml.entitlement.domain_objects_0_1_0.Subject;

import java.util.List;

/**
 * User: Deringer
 * Date: 8/10/11
 * Time: 10:14 AM
 */
public interface EntitlementModel {

    /**
     * Create a new entitlement policy. The policy will create an authorization
     * to the resource by the subject. The type of authorization is defined by
     * the action.
     * @param realm The security realm.
     * @param subject The user, or machine, to be given authorization.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @param action The type of authorization (READ, WRITE, ADMIN).
     * @param authorizingSubject The user, with admin privileges, assigning the authorization.
     */
    void createPolicy(
            String realm, String subject, String resource,
            String action, String authorizingSubject);

    /**
     * Update an existing entitlement policy, the policy is an authorization
     * to a resource by a subject.
     * @param realm The security realm.
     * @param subject The user, or machine, to be given authorization.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @param action The type of authorization (READ, WRITE, ADMIN).
     * @param authorizingSubject The user, with admin privileges, assigning the authorization.
     */
    void updatePolicy(
            String realm, String subject, String resource,
            String action, String authorizingSubject);

    /**
     * Remove an existing entitlement policy.
     * @param policyKey The policies unique identifier.
     * @param authorizingSubject The user, with admin privileges, removing the authorization.
     */
    void removePolicy(Long policyKey, String authorizingSubject);

    /**
     * Remove an existing entitlement policy, the policy is an authorization
     * to a resource by a subject.
     * @param realm The security realm.
     * @param subject The user, or machine, with the authorization.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @param authorizingSubject The user, with admin privileges, removing the authorization.
     */
    void removePolicy(
            String realm, String subject, String resource, String authorizingSubject);

    /**
     * Retrieves a list of all Entitlement Policies.
     * @return A list of EntitlementPolicy objects containing the subject,
     * resource and action of the authorization.
     */
    List<EntitlementPolicy> getAllPolicies();

    /**
     * Retrieves a list of all Entitlement Policies for a particular subject.
     * @param realm The security realm.
     * @param subject The user, or machine, with the authorization.
     * @return A list of EntitlementPolicy objects containing the subject,
     * resource and action of the authorization.
     */
    List<EntitlementPolicy> getPolicyBySubject(String realm, String subject);

    /**
     * Retrieves a list of all Entitlement Policies for a particular resource.
     * @param realm The security realm.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @return A list of EntitlementPolicy objects containing the subject,
     * resource and action of the authorization.
     */
    List<EntitlementPolicy> getPolicyByResource(String realm, String resource);

    /**
     * Retrieves a list of all Entitlement Policies for a particular resource.
     * @param realm The security realm.
     * @return A list of EntitlementPolicy objects containing the subject,
     * resource and action of the authorization.
     */
    List<EntitlementPolicy> getPolicyByRealm(String realm);

    /**
     * Retrieves an Entitlement Policy
     * @param policyKey The unique identifier of a policy.
     * @return An EntitlementPolicy object containing the subject,
     * resource and action of the authorization.
     */
    EntitlementPolicy getPolicy(Long policyKey);

    /**
     * Retrieves an Entitlement Policy
     * @param realm The security realm.
     * @param subject The user, or machine, with the authorization.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @return An EntitlementPolicy object containing the subject,
     * resource and action of the authorization.
     */
    EntitlementPolicy getPolicy(
            String realm, String subject, String resource);

    /**
     * Returns the type of authorization for a given policy.
     * @param realm The security realm.
     * @param subject The user, or machine, with the authorization.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @return An Action enum object containing the type of authorization (READ, WRITE, ADMIN)
     * @see org.nterlearning.xml.entitlement.domain_objects_0_1_0.Action
     */
    Action getAuthorization(
            String realm, String subject, String resource);

    /**
     * Returns a list of authorization types
     * @return A list of Action enum objects (READ, WRITE, ADMIN).
     * @see org.nterlearning.xml.entitlement.domain_objects_0_1_0.Action
     */
    List<Action> getActions();

    /**
     * Returns a list of security realms
     * @return A list of String objects contains realm names
     */
    List<String> getRealms();

    /**
     * Returns a list of subjects
     * @return A list of String objects containing subjects
     */
    List<String> getSubjects();

    /**
     * Returns a list of resources
     * @return A list of String objects containing resources
     */
    List<String> getResources();

    /**
     * Returns a boolean, 'true', if a subject has authorization for the resource
     * at the level, or greater, of the permission specified in the action parameter.
     * @param realm The security realm.
     * @param subject The user, or machine, with the authorization.
     * @param resource The target of the authorization, generally an
     * institution such as an NTER or Content Repository instance.
     * @param action An Action enum object containing the type of authorization (READ, WRITE, ADMIN)
     * @see org.nterlearning.xml.entitlement.domain_objects_0_1_0.Action
     * @return A boolean specifying if the subject has the authorization level,
     * of greater, of the specified action to the resource.
     */
    boolean isAuthorized(String realm, String subject, String resource, Action action);

    /**
     * Returns true if the subject has Global Admin privileges
     * @param realm The security realm.
     * @param subject The user, or machine, with the authorization.
     * @return A boolean specifying if the subject is a Global Admin.
     */
    boolean isGlobalAdmin(String realm, String subject);


}
