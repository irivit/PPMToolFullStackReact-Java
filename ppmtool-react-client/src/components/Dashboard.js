import React, { Component } from 'react'
import ProjectItem from './Project/ProjectItem';
import { directive } from '@babel/types';

class Dashboard extends Component {
  render() {
    return (
    <div>
       <h1 className="alert alert-warning">Project</h1>
        <ProjectItem/>
        <ProjectItem/>
    </div>
    );
  }
}


export default Dashboard;