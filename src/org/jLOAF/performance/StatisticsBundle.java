/** StatisticsBundle.java in the package org.JIFSA.performance of the JIFSA project.
    Originally created 16-Feb-08

    Copyright (C) 2008 Michael W. Floyd

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

 * 
 */
package org.jLOAF.performance;

/** Used to bundle together the statistics that are generated by StatisticsWrapper
 * so that they can easily be retrieved.
 * 
 * @author Michael W. Floyd
 * @since 0.5
 */
public class StatisticsBundle {

	private float[] m_stats;
	private String[] m_labels;
	private int m_primary;
	
	/** Creates a StatisticsBundle that contains statistics as well as
	 * the label for those statistics.
	 * 
	 * @param statistics the statistics to store
	 * @param labels the labels for the statistics
	 * 
	 * @author Michael W. Floyd
	 * @since 0.5
	 */
	public StatisticsBundle(float[] statistics, String[] labels){
		if(statistics.length != labels.length){
			throw new IllegalArgumentException("Number of statistics different from number of labels");
		}
		if(statistics.length == 0){
			throw new IllegalArgumentException("At least one statistic is required for a StatisticsBundle");
		}
		
		this.m_primary = 0;
		this.m_stats = statistics;
		this.m_labels = labels;
	}
	
	/** Returns the statistic that was set as the primary statistic. This
	 * is typically used when an algorithm is attempting to maximize a single
	 * statistic.
	 * 
	 * @return the primary statistic
	 *
	 * @author Michael W. Floyd
	 * @since 0.5
	 */
	public float getPrimaryStatistic(){
		return this.m_stats[this.m_primary];
	}
	
	/** Returns the label of the primary statistic.
	 * 
	 * @return the label of the primary statistic
	 *
	 * @author Michael W. Floyd
	 * @since 0.5
	 */
	public String getPrimaryLabel(){
		return this.m_labels[this.m_primary];
	}
	
	/** Returns all of the statistics in the bundle
	 * 
	 * @return the statistics
	 * 
	 * @author Michael W. Floyd
	 * @since 0.5
	 */
	public float[] getAllStatistics(){
		return this.m_stats;
	}
	
	/** Returns all of the labels
	 * 
	 * @return the labels
	 * 
	 * @author Michael W. Floyd
	 * @since 0.5
	 */
	public String[] getLabels(){
		return this.m_labels;
	}
	
	/** Sets the primary statistic to the statistic with the given index.
	 * The statistic index can be found by searching the labels for the label
	 * of the desired statistic and using the index of that label.
	 * 
	 * @param index the index of the new primary statistic
	 * 
	 * @author Michael W. Floyd
	 * @since 0.5
	 */
	public void setPrimaryStatistic(int index){
		if(index > this.m_stats.length - 1){
			throw new IllegalArgumentException("Invalid statistic index given - too high.");
		}
		
		if(index < 0){
			throw new IllegalArgumentException("Invalid statistic index given - too low.");
		}
		
		this.m_primary = index;
	}
}