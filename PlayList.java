/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) 
    {
        //// replace the following statement with your code

        if (this.getSize() == this.getMaxSize())
            return false;


        if (size < maxSize) 
            {
                tracks[size++] = track;
                return true;
            }

            return false;
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() 
    {   //// replace the following statement with your code
        String playlist = " ";

        for (int i=0; i<tracks.length; i++)
        {
            if (tracks[i] != null)
            {
                playlist += tracks[i].toString() + "\n";
            }
            
        }
        return playlist.toString();
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() 
    {

        //// replace this comment with your code
        if (tracks[0]!= null)
        {
                for (int i = tracks.length - 1; i >= 0; i--)
            {
                if (tracks[i] != null)
                {
                    tracks[i]=null;
                    size -- ;
                    break;
                }
            }
        }

    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() 
    {   //// replace the following statement with your code
        int total = 0;
        for (int i=0;i<tracks.length;i++)
        {
            if (tracks[i] != null)
            {
                total +=  tracks[i].getDuration();
            }
        }
        return total;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) 
    {   //// replace the following statement with your code
        for (int i=0;i<tracks.length;i++)
        {
            if (tracks[i] != null && tracks[i].getTitle().equals(title))
                return i;
        }
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) 
    {   
        //// replace the following statement with your code

        if ( i < 0 || i >= this.getMaxSize() || this.getSize() == this.getMaxSize() )
            return false;
        
        if (this.getSize() == 0)
        {
            tracks[0] = track;
            return true;
        }

        
        for (int j=tracks.length-1;j>=i;j--)
            {
                if (j==i)
                {
                    tracks[j] = track;
                    size++;
                    return true;
                }
                    tracks[j] = tracks [j-1];
                    
            }

        return false;

    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i)
    {    //// replace this comment with your code

       if (i >= 0 && i < tracks.length && tracks[i] != null)
        {
            for (int j = i; j < tracks.length - 1; j++) 
            
               { 
                    tracks[j] = tracks[j + 1];
               }
        

            tracks[tracks.length - 1] = null;
            size -- ;
            }

    }

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title)
    { //// replace this comment with your code
        int index = indexOf(title);

        if (this.getSize() !=0 && index != -1)
        {
            remove(index);
        }

    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst()
    { //// replace this comment with your code
        
        if (this.getSize() > 0)
        {
            for (int i = 0; i < tracks.length - 1; i++) 
            {
                tracks[i] = tracks[i + 1];
            }

            tracks[tracks.length-1] = null;
            size--;

        }
    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) 
    {//// replace this comment with your code

        int totalSize = this.getSize() + other.getSize();
        if (totalSize > this.getMaxSize())
            return ;
        
        int currentIndex = this.getSize()+1;

            for (int j=0; j< other.size; j++)
            {    
                if (currentIndex < this.getMaxSize())
                {
                    this.tracks[currentIndex] = other.getTrack(j);
                    currentIndex++;
                    this.size++;
                }
                else
                {
                    break;
                }
                
            }
        }

    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) 
    { //// replace the following statement with your code
        int min=Integer.MAX_VALUE;
        int minIndex1 = -1;

        if (start < 0 || start >= this.getSize())
        {
            return -1;
        }
        else 
        {
            for (int i=start; i<tracks.length; i++)
            {
                if (tracks[i] != null && (( tracks[i].getDuration() < min) || minIndex1 == -1 ))
                    { 
                        min = tracks[i].getDuration();
                        minIndex1 = i;
                    }
            }
        }
        return minIndex1;
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() 
    {  
        if (this.getSize() == 0) 
            return null; 

        int minIndex = 0;
        int min = tracks[0].getDuration();
        for (int i=1; i<tracks.length; i++)
        {
            if (tracks[i] != null && tracks[i].getDuration() < min )
                {
                    min = tracks[i].getDuration() ;
                    minIndex = i; 
                }
        }
        return tracks[minIndex].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() 
    {

        for (int i=0; i<tracks.length-1; i++)
        {
            int minIndex = minIndex(i);
            if (minIndex != -1 && minIndex != i)
            {
                Track temp1 = tracks[minIndex];
                Track temp2 = tracks[i];

                tracks[i] = temp1;
                tracks [minIndex] = temp2;
            }
            
        }

        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
    }
}
    


