/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.activiti.model.editor;

import java.util.Date;

import com.activiti.domain.editor.AbstractModel;
import com.activiti.domain.editor.Model;
import com.activiti.domain.editor.ModelHistory;
import com.activiti.model.common.AbstractRepresentation;

/**
 * Representation of process-models, both current and historic models.
 * 
 * @author Tijs Rademakers
 */
public class ModelRepresentation extends AbstractRepresentation {

  protected Long id;
  protected String name;
  protected String key;
  protected String description;
  protected String createdBy;
  protected String lastUpdatedBy;
  protected Date lastUpdated;
  protected boolean latestVersion;
  protected int version;
  protected String comment;
  protected Long referenceId;
  protected Integer modelType;

  public ModelRepresentation(AbstractModel model) {
    initialize(model);
  }

  public ModelRepresentation() {

  }

  public void initialize(AbstractModel model) {
    this.id = model.getId();
    this.name = model.getName();
    this.key = model.getKey();
    this.description = model.getDescription();
    this.createdBy = model.getCreatedBy();
    this.lastUpdated = model.getLastUpdated();
    this.version = model.getVersion();
    this.lastUpdatedBy = model.getLastUpdatedBy();
    this.comment = model.getComment();
    this.referenceId = model.getReferenceId();
    this.modelType = model.getModelType();

    // When based on a ProcessModel and not history, this is always the latest version
    if (model instanceof Model) {
      this.setLatestVersion(true);
    } else if (model instanceof ModelHistory) {
      this.setLatestVersion(false);
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public void setLatestVersion(boolean latestVersion) {
    this.latestVersion = latestVersion;
  }

  public boolean isLatestVersion() {
    return latestVersion;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }

  public Long getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(Long referenceId) {
    this.referenceId = referenceId;
  }

  public Integer getModelType() {
    return modelType;
  }

  public void setModelType(Integer modelType) {
    this.modelType = modelType;
  }

  public Model toModel() {
    Model model = new Model();
    model.setName(name);
    model.setDescription(description);
    return model;
  }

  /**
   * Update all editable properties of the given {@link Model} based on the values in this instance.
   */
  public void updateModel(Model model) {
    model.setDescription(this.description);
    model.setName(this.name);
  }
}
