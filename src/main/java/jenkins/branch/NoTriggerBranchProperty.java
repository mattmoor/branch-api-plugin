/*
 * The MIT License
 *
 * Copyright (c) 2013, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.branch;

import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import jenkins.scm.api.SCMRevision;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * A branch property that blocks scheduling of projects on this branch due
 * to source changes.
 *
 * @author Matt Moore
 */
@SuppressWarnings("unused") // instantiated by stapler
public class NoTriggerBranchProperty extends BranchProperty {
    /** Constructor for stapler. */
    @DataBoundConstructor
    @SuppressWarnings("unused") // instantiated by stapler
    public NoTriggerBranchProperty() {
    }

    /** {@inheritDoc} */
    @Override
    public <P extends AbstractProject<P,B>,B extends AbstractBuild<P,B>> boolean shouldSchedule(
        P project, Branch branch, SCMRevision revision) {
      return false;
    }

    /** Our descriptor */
    @Extension
    @SuppressWarnings("unused") // instantiated by jenkins
    public static class DescriptorImpl extends BranchPropertyDescriptor {
        /** {@inheritDoc} */
        @Override
        public String getDisplayName() {
            return Messages.NoTriggerBranchProperty_DisplayName();
        }
    }
}
