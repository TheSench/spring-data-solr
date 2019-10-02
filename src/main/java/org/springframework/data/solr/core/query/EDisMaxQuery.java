package org.springframework.data.solr.core.query;

import org.springframework.lang.Nullable;

/**
 * Query to be used for DisMax query type.
 *
 * @author Matthew Hall
 * @author Jon Senchyna
 */
public interface EDisMaxQuery extends DisMaxQuery {

  @Nullable
  EDisMaxOptions getEDisMaxOptions();

  <T extends SolrDataQuery> T setDisMaxOptions(EDisMaxOptions eDisMaxOptions);

}
