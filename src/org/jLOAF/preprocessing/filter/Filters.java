package org.jLOAF.preprocessing.filter;

import org.jLOAF.preprocessing.filter.casebasefilter.Clustering;
import org.jLOAF.preprocessing.filter.casebasefilter.Sampling;
import org.jLOAF.preprocessing.filter.featureSelection.GeneticAlgorithmWeightSelector;
import org.jLOAF.preprocessing.filter.featureSelection.HillClimbingFeatureSelection;
import org.jLOAF.preprocessing.filter.featureSelection.SequentialBackwardGeneration;
import org.jLOAF.preprocessing.filter.featureSelection.WeightsSeperatorFilter;
/**
 * this enum is only used for testing purposes, it is used to return an instance of a casebase filter, which corresponds to the string representation
 * of its name.
 * 
 * @author Ibrahim Ali Fawaz
 *
 */
public enum Filters {

	clustering(new Clustering(null)),sampling(new Sampling(null)),geneticAlgorithm(new GeneticAlgorithmWeightSelector(null))
	,hillClimbing(new HillClimbingFeatureSelection(null)),sequentialBackwardAlgorithm(new SequentialBackwardGeneration(null,5,0.9))
	,weightsSeperator(new WeightsSeperatorFilter(null));
	
		CaseBaseFilter fs ;
		
	Filters(CaseBaseFilter fs){
		this.fs=fs;
	}
	
	/**
	 * 
	 * @return the caseBase filter of this enumerated element
	 */
	public CaseBaseFilter getFilter(){
		return fs;
	}
	
}